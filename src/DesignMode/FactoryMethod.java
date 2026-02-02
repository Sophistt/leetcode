package DesignMode;

public class FactoryMethod {

    // 符合开闭原则
    public abstract static class Fruit {
        private final String name;

        public Fruit(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name + "@" + hashCode();
        }
    }

    public static class Apple extends Fruit {
        public Apple() {
            super("apple");
        }
    }

    public static class Orange extends Fruit {
        public Orange() {
            super("orange");
        }
    }

    // 符合开闭原则
    public static abstract class FruitFactory<T extends Fruit> {
        public abstract T getFruit();
    }

    public static class AppleFactory extends FruitFactory<Apple> {
        @Override
        public Apple getFruit() {
            return new Apple();
        }
    }

    public static class OrangeFactory extends FruitFactory<Orange> {
        @Override
        public Orange getFruit() {
            return new Orange();
        }
    }
}


