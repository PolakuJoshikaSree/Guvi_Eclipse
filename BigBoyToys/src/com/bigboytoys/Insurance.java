package com.bigboytoys;

// The Insurance interface is used to define how different insurance plans are calculated for a vehicle.
// It’s used to show Abstraction and Polymorphism where different implementations are possible)=.
public interface Insurance {
    double calculateInsurance(double price, boolean includeThirdParty);
}
//car class implements calculateInsurance shows polymorphism.and defines common method for calculateInsuarnce shows Abstraction.