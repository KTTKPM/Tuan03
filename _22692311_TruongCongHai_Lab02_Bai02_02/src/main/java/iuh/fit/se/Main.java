package iuh.fit.se;

import iuh.fit.se.decorator.BasePriceComponent;
import iuh.fit.se.decorator.ExciseDecorator;
import iuh.fit.se.decorator.LuxuryDecorator;
import iuh.fit.se.decorator.PriceComponent;
import iuh.fit.se.decorator.VatDecorator;
import iuh.fit.se.model.Product;
import iuh.fit.se.model.ProductType;
import iuh.fit.se.state.LuxuryControlState;
import iuh.fit.se.state.StandardTaxState;
import iuh.fit.se.state.TaxContext;
import iuh.fit.se.state.TaxHolidayState;
import iuh.fit.se.strategy.ExciseTaxStrategy;
import iuh.fit.se.strategy.LuxuryTaxStrategy;
import iuh.fit.se.strategy.TaxStrategy;
import iuh.fit.se.strategy.VatTaxStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Gao huu co", 150_000, ProductType.ESSENTIAL),
                new Product("Nuoc ngot", 40_000, ProductType.HARMFUL),
                new Product("Dong ho cao cap", 12_000_000, ProductType.LUXURY)
        );

        TaxContext taxContext = new TaxContext(new StandardTaxState());

        System.out.println("=== MO PHONG TINH THUE SAN PHAM (State + Strategy + Decorator) ===");
        runScenario("Trang thai 1: Thuong", products, taxContext);

        taxContext.setState(new TaxHolidayState());
        runScenario("Trang thai 2: Uu dai thue", products, taxContext);

        taxContext.setState(new LuxuryControlState());
        runScenario("Trang thai 3: Kiem soat hang xa xi", products, taxContext);

        System.out.println("\nKET LUAN:");
        System.out.println("- State: doi chinh sach thue theo boi canh ma khong sua logic tinh thue.");
        System.out.println("- Strategy: moi loai thue (VAT, tieu thu, xa xi) la mot chien luoc co the thay doi.");
        System.out.println("- Decorator: ghep nhieu lop thue len san pham linh hoat, khong sua lop san pham goc.");
    }

    private static void runScenario(String title, List<Product> products, TaxContext taxContext) {
        System.out.println("\n" + title + " [State = " + taxContext.getStateName() + "]");
        for (Product product : products) {
            PriceComponent pricedProduct = buildDecoratedPrice(product, taxContext);
            System.out.printf("- %-20s | Gia goc: %,12.0f | Tong sau thue: %,12.0f | %s%n",
                    product.name(),
                    product.basePrice(),
                    pricedProduct.getTotalPrice(),
                    pricedProduct.getDescription()
            );
        }
    }

    private static PriceComponent buildDecoratedPrice(Product product, TaxContext context) {
        PriceComponent component = new BasePriceComponent(product);
        for (TaxStrategy strategy : chooseStrategies(product.type())) {
            if (strategy instanceof VatTaxStrategy vat) {
                component = new VatDecorator(component, context, vat);
            } else if (strategy instanceof ExciseTaxStrategy excise) {
                component = new ExciseDecorator(component, context, excise);
            } else if (strategy instanceof LuxuryTaxStrategy luxury) {
                component = new LuxuryDecorator(component, context, luxury);
            }
        }
        return component;
    }

    private static List<TaxStrategy> chooseStrategies(ProductType type) {
        List<TaxStrategy> strategies = new ArrayList<>();
        switch (type) {
            case ESSENTIAL -> strategies.add(new VatTaxStrategy(0.05));
            case REGULAR -> strategies.add(new VatTaxStrategy(0.10));
            case HARMFUL -> {
                strategies.add(new VatTaxStrategy(0.10));
                strategies.add(new ExciseTaxStrategy(0.15));
            }
            case LUXURY -> {
                strategies.add(new VatTaxStrategy(0.10));
                strategies.add(new LuxuryTaxStrategy(0.20));
            }
        }
        return strategies;
    }
}