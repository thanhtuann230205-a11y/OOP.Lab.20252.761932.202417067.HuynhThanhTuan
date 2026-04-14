public class TestPassingParameter {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: " + anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(dvd1); 
        System.out.println("Total Cost after removing 'The Lion King': " + anOrder.totalCost());
        System.out.println("--------------------------------------------");
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        System.out.println("Before swap: " + jungleDVD.getTitle() + " / " + cinderellaDVD.getTitle());
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap: " + jungleDVD.getTitle() + " / " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle: " + jungleDVD.getTitle());
    }
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String oldTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(oldTitle);
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}