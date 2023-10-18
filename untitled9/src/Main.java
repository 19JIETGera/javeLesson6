import java.io.IOException;
import java.util.*;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
// Реализовать в java.
//Создать множество ноутбуков.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
// и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//Например:
//“Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ
//2 - Объем ЖД
//3 - Операционная система
//4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев -
// сохранить параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
//Работу сдать как обычно ссылкой на гит репозиторий
//Частые ошибки:
//1. Заставляете пользователя вводить все существующие критерии фильтрации
//2. Невозможно использовать более одного критерия фильтрации одновременно
//3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру,
// а не всем введенным пользователем
//4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять
// характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
public class Main {
    public static void main(String[] args) throws IOException {
        Notebook notebook = new Notebook();
        FillingTheData dataSet = new FillingTheData();
        Set<Notebook> notebookSet = new HashSet<>();
        dataSet.setRandomNotebook(notebookSet);
        Set<Integer> numberParametr = new HashSet<>();
        numberParametr = setNumberParametr(numberParametr);
        Search search = new Search();
        Set<Notebook> resSearch = new HashSet<>();
        resSearch = search.search(notebookSet,numberParametr,resSearch);
        /*for (Notebook item : notebookSet) { // вывод всех ноутбуков
            System.out.println("ОЗУ: " + item.getRam() + " Объем ЖД: " + item.getMemory() + " Операционная система: " + item.getOs() + " Цвет: " + item.getColour() + " Процессор: " + item.getProcessor() + " Диагональ экрана: " + item.getScreenDiagonal());
        }
        System.out.println('\n');*/
        if (resSearch.size()!=0) {
            for (Notebook item : resSearch) {
                System.out.println("ОЗУ: " + item.getRam() + " Объем ЖД: " + item.getMemory() + " Операционная система: " + item.getOs() + " Цвет: " + item.getColour() + " Процессор: " + item.getProcessor() + " Диагональ экрана: " + item.getScreenDiagonal());
            }
        }else {
            System.out.println("Таких ноутбуков у нас сейчас нет, попробуйдет найти другой");
        }
    }
    public static Set<Integer> setNumberParametr(Set<Integer> numberParametr){
        Scanner console = new Scanner(System.in);
        System.out.println("Введите номера интересующих вас характеристик через Enter\n" +"1- ОЗУ \n" + "2- Объем ЖД \n" + "3- Операционная система \n" + "4- Цвет \n" + "5- Процессор \n" + "6- Диагональ экрана\n" + "0 - Для выхода из режима ввода");
        Integer i = console.nextInt();
        while (i!=0 || numberParametr.size()>6){
            numberParametr.add(i);
            i = console.nextInt();
        }
        return numberParametr;
    }
}
class FillingTheData {
    static void setRandomNotebook(Set<Notebook> notebookSet) {
        Random random = new Random();
        int[] arrRam = new int[]{1, 4, 8, 16};
        int[] arrMemory = new int[]{126, 252, 500, 1000};
        LinkedList<String> arrOs = new LinkedList<>();
        arrOs.add("MacOS");
        arrOs.add("Linux");
        arrOs.add("Windows 11");
        LinkedList<String> arrColour = new LinkedList<>();
        arrColour.add("Red");
        arrColour.add("Yellow");
        arrColour.add("Black");
        arrColour.add("Gray");
        arrColour.add("White");
        arrColour.add("Blue");
        LinkedList<String> arrProcessor = new LinkedList<>();
        arrProcessor.add("iCore 7");
        arrProcessor.add("iCore 5");
        arrProcessor.add("iCore 3");
        arrProcessor.add("iCore 9");
        int[] arrScreenDiagonal = new int[]{15, 17, 21, 13};
        int i = 0;
        while (i <= 10) {
            Notebook notebook = new Notebook();
            notebook.setRam(randomIntArrElement(arrRam));
            notebook.setMemory(randomIntArrElement(arrMemory));
            notebook.setOs(arrOs.get(random.nextInt(arrOs.size())));
            notebook.setColour(arrColour.get(random.nextInt(arrColour.size())));
            notebook.setProcessor(arrProcessor.get(random.nextInt(arrProcessor.size())));
            notebook.setScreenDiagonal(randomIntArrElement(arrScreenDiagonal));
            notebookSet.add(notebook);
            i++;
        }
    }
    private static int randomIntArrElement(int[] array){
        Random random = new Random();
        int rnd = random.nextInt(array.length);
        return array[rnd];
    }
}
class Search {
    public static Set<Notebook> search(Set<Notebook> notebookSet, Set<Integer> numberParametr, Set<Notebook> resSearch) {
        int sizeNumberParamtr = numberParametr.size();
        resSearch = searchParametr(notebookSet,numberParametr);
        switch (sizeNumberParamtr){
            case 1: break;
            case 2:
                resSearch = searchParametr(resSearch,numberParametr);
                break;
            case 3:
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                break;
            case 4:
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                break;
            case 5:
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                break;
            case 6:
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                resSearch = searchParametr(resSearch,numberParametr);
                break;
            default:
                System.out.println("Вы ввели недопустимое количество параметров поиска");
                break;
        }
        return resSearch;
    }

    private static Set<Notebook> searchParametr(Set<Notebook> notebookSet, Set<Integer> numberParametr) {
        Scanner console = new Scanner(System.in);
        Set<Notebook> resSearch = new HashSet<>();
        for (Integer item : numberParametr) {
            switch (item) {
                case 1:
                    System.out.println("Введите минимальные параметры ОЗУ (1, 4, 8, 16):");
                    int i = console.nextInt();
                    for (Notebook itemNotebook : notebookSet) {
                        int ram = itemNotebook.getRam();
                        if (i <= ram) {
                            resSearch.add(itemNotebook);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите минимальные параметры Объема ЖД (126, 252, 500, 1000):");
                    int i1 = console.nextInt();
                    for (Notebook itemNotebook : notebookSet) {
                        int memory = itemNotebook.getMemory();
                        if (i1 <= memory) {
                            resSearch.add(itemNotebook);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Выберете желаемую операционную систему (MacOS, Linux, Windows 11):");
                    String i2 = console.nextLine();
                    for (Notebook itemNotebook : notebookSet) {
                        String os = itemNotebook.getOs();
                        if (i2.equals(os)) {
                            resSearch.add(itemNotebook);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Выберите желаемый цвет (Red, Yellow, Black, Gray, White, Blue):");
                    String i3 = console.nextLine();
                    for (Notebook itemNotebook : notebookSet) {
                        String colour = itemNotebook.getColour();
                        if (i3.equals(colour)) {
                            resSearch.add(itemNotebook);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Выберите желаемый процессор (iCore 7, iCore 5, iCore 3, iCore 9):");
                    String i4 = console.nextLine();
                    for (Notebook itemNotebook : notebookSet) {
                        String processor = itemNotebook.getProcessor();
                        if (i4.equals(processor)) {
                            resSearch.add(itemNotebook);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Введите минимальные Диагональ экрана (13, 15, 17, 21):");
                    int i5 = console.nextInt();
                    for (Notebook itemNotebook : notebookSet) {
                        int screenDiagonal = itemNotebook.getScreenDiagonal();
                        if (i5 <= screenDiagonal) {
                            resSearch.add(itemNotebook);
                        }
                    }
                    break;
                default:
                    System.out.println("Вы ввели неправильный параметр:");
                    break;
            }
            numberParametr.remove(item);
            break;
        }
        return resSearch;
    }
}