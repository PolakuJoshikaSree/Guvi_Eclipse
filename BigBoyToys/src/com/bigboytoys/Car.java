package com.bigboytoys;

// Car class extends Vehicle and implements Insurance.
// This class represents implementation of Vehicle .
//It demonstrates Inheritance from Vehicle and Polymorphism showing method overriding & overloading.

public class Car extends Vehicle implements Insurance {

    private int engineCC;

    // using Constructors to set brand, model, and engine .
    public Car(String brand, String model, double exShowroomPrice, int engineCC) {
        super(brand, model, exShowroomPrice);
        this.engineCC = engineCC;
    }
    
    //This method overrides the abstract method from Vehicle.By calculating the onroad price.
    //On-Road Price = Exshowroom + ImporTDuty (60%) + GST (40%) + LuxuryTax (if 6750cc) + 12% Onroad charge

    @Override
    public double calculateOnRoadPrice() {
        double ex = getExShowroomPrice();//using get shows encapsulation here.
        double importDuty = 0.60 * ex;
        double gst = 0.40 * ex;
        double luxuryTax = (engineCC == 6750) ? 0.20 * ex : 0.0;
        double roadCharge = 0.12 * ex;
        return ex + importDuty + gst + luxuryTax + roadCharge;
    }

    // Method Overloading — demonstrates Compile-time Polymorphism.
    //This version is used for only insurance plan that uses 10%.
    public double calculateInsurance(double price) {
        return 0.10 * price;
    }

    // Interface method implementation .It overrides the method and gives the complete formula for both insurance plans.
    // Demonstrates Runtime Polymorphism by giving a different behavior at runtime.
    
    @Override
    public double calculateInsurance(double price, boolean includeThirdParty) {
        if (!includeThirdParty) {
            return calculateInsurance(price); // reusing overloaded method
        } else {
            // Formula given in doc:
            // 10% + 5% - 20% NCB + 18% GST
            double base = 0.10 * price;
            double thirdParty = 0.05 * price;
            double ncb = 0.20 * price;
            double gst = 0.18 * price;
            return base + thirdParty - ncb + gst;
        }
    }
}
