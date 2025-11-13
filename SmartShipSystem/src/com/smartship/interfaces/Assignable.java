package com.smartship.interfaces;

import com.smartship.core.DeliveryPackage;
import com.smartship.exceptions.OverloadException;

public interface Assignable {
    void assignPackage(Package pkg) throws OverloadException;
    int getPackageCount();
}
