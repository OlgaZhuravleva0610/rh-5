
    public class Money {
        private long rubles;
        private byte kopecks;

        public Money(long rubles, byte kopecks) {
            if (kopecks < 0 || kopecks > 99) {
                throw new IllegalArgumentException("ошибка, копейки не могут быть больше 99");
            }
            this.rubles = rubles;
            this.kopecks = kopecks;
        }

        public Money add(Money other) {
            long newRubles = this.rubles + other.rubles;
            int newKopecks = this.kopecks + other.kopecks;
            if (newKopecks >= 100) {
                newRubles++;
                newKopecks -= 100;
            }
            return new Money(newRubles, (byte) newKopecks);
        }

        public Money subtract(Money other) {
            long newRubles = this.rubles - other.rubles;
            int newKopecks = this.kopecks - other.kopecks;
            if (newKopecks < 0) {
                newRubles--;
                newKopecks += 100;
            }
            return new Money(newRubles, (byte) newKopecks);
        }

        public Money divide(Money other) {
            double thisAmount = this.rubles + this.kopecks / 100.0;
            double otherAmount = other.rubles + other.kopecks / 100.0;
            return new Money((long) (thisAmount / otherAmount), (byte) ((thisAmount % otherAmount) * 100));
        }

        public Money divide(double divisor) {
            double thisAmount = this.rubles + this.kopecks / 100.0;
            double result = thisAmount / divisor;
            return new Money((long) result, (byte) ((result - (long) result) * 100));
        }

        public Money multiply(double multiplier) {
            double thisAmount = this.rubles + this.kopecks / 100.0;
            double result = thisAmount * multiplier;
            return new Money((long) result, (byte) ((result - (long) result) * 100));
        }

        public boolean equals(Money other) {
            return this.rubles == other.rubles && this.kopecks == other.kopecks;
        }

        public void print() {
            System.out.printf("%d,%d руб.", this.rubles, this.kopecks);
        }

        public static void main(String[] args) {
            Money money1 = new Money(10, (byte) 50);
            Money money2 = new Money(10, (byte) 50);

            Money sum = money1.add(money2);
            sum.print();

            Money difference = money1.subtract(money2);
            difference.print();

            Money division = money1.divide(money2);
            division.print();

            Money divisionByNumber = money1.divide(2);
            divisionByNumber.print();

            Money multiplication = money1.multiply(3);
            multiplication.print();

            if (money1.equals(money2)) {
                System.out.println("одна и та же сумма");
            }
        }
    }

