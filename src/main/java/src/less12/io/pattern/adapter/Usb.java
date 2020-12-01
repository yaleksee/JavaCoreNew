package src.less12.io.pattern.adapter;

public interface Usb {
    void connectWithUsbCable();
}

class MemoryCard {

    public void insert() {
        System.out.println("Карта памяти успешно вставлена!");
    }

    public void copyData() {
        System.out.println("Данные скопированы на компьютер!");
    }
}

class CardReader implements Usb {

    // Адаптируемый класс (карта памяти) становится одним из полей адаптера.
    private MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
    }
}

class User {

    public static void main(String[] args) {

        Usb cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();

    }
}
