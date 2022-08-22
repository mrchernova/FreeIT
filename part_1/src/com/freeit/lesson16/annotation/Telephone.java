package com.freeit.lesson16.annotation;



@NotSecretPhone
public class Telephone {

    private String phoneModel;
    private boolean isBlocked = true;

    public Telephone(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public void ring() {
        System.out.println("Ring ring ring ring ring ring ring ring ring ring ring");
    }

    public void takePhoto() {
        if (!isBlocked) {
            System.out.println("Click click");
        }
    }

    @PhoneIsGenerallyAvailable(available = false)
    private void unblock() {
        System.out.println("Phone is unblocked by");
        isBlocked = false;
    }
}