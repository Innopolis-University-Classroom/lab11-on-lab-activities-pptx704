interface LightningPort {
    void chargeByLightning();
}

interface UspPort {
    void chargeByUsp();
}

class Android implements UspPort {
    int charge = 0;
    
    public void chargeByUsp(){
        charge = 100;
        System.out.println("Charged");
    }
}

class Iphone implements LightningPort {
    int charge = 0;
    public void chargeByLightning(){
        charge = 100;
        System.out.println("Charged");
    }
}

class Adapter implements LightningPort, UspPort{
    Android android;
    Iphone iphone;
    public void addAndroid(Android android){
        this.android = android;
    }

    public void addIphone(Iphone iphone){
        this.iphone = iphone;
    }

    public void chargeByLightning() {
        this.android.chargeByUsp();
    }

    public void chargeByUsp(){
        this.iphone.chargeByLightning();
    }
}

class ChargeStation {
    void chargeByLightning(LightningPort port){
        port.chargeByLightning();
    }
}

public class problem2 {
    public static void main(String[] args) {
        Android phone = new Android();
        System.out.println(phone.charge);
        Adapter adapter = new Adapter();
        adapter.addAndroid(phone);
        ChargeStation station = new ChargeStation();
        station.chargeByLightning(adapter);
        System.out.println(phone.charge);
    }
}