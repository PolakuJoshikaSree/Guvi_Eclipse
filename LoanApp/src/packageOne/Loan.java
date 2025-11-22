package packageOne;

class Loan {
    double amount;
    double rate;
    int years;
    double downPayment;

    Loan(double amount, double rate, int years, double downPayment) {
        this.amount = amount;
        this.rate = rate;
        this.years = years;
        this.downPayment = downPayment;
    }

    // Simple Interest total amount
    double totalAmount() {
        double principal = amount - downPayment;
        double interest = (principal * rate * years) / 100;
        return principal + interest;
    }

    // Compound Interest total amount
    double compoundTotalAmount() {
        double principal = amount - downPayment;
        return principal * Math.pow((1 + (rate / 100.0)), years);
    }

    // EMI using Simple Interest
    double emi() {
        int months = years * 12;
        return totalAmount() / months;
    }

    // EMI using Compound Interest
    double compoundEmi() {
        int months = years * 12;
        return compoundTotalAmount() / months;
    }
}