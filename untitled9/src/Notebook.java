import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Notebook {
    private int ram; //1 - ОЗУ
    private int memory; //2 - Объем ЖД
    private String os; //3 - Операционная система
    private String colour; //4 - Цвет
    private String processor; //5- Процессор
    private int screenDiagonal; //6- Диагональ экрана

    public int getRam(){
        return ram;
    }
    public void setRam (int ram){
        this.ram = ram;
    }
    public  int getMemory(){
        return memory;
    }
    public  void setMemory(int memory){
        this.memory = memory;
    }
    public int getScreenDiagonal(){
        return screenDiagonal;
    }
    public void setScreenDiagonal(int screenDiagonal){
        this.screenDiagonal = screenDiagonal;
    }
    public String getProcessor(){
        return processor;
    }
    public void setProcessor(String processor){
        this.processor = processor;
    }
    public String getOs(){
        return os;
    }
    public void setOs (String os){
        this.os = os;
    }
    public String getColour(){
        return colour;
    }
    public void setColour(String colour){
        this.colour = colour;
    }


}
