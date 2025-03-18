public class Kalkulator {
    int a, b;
    public Kalkulator(){
    }
    public Kalkulator(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int tambah(){
        return a + b;
    }
    public int kurang(){
        return a - b;
    }

    public int bagi(){
        return a / b;
    }
    public int kali(){
        return a * b;
    }
    public int add(int a, int b){
        return a + b;
    }

    public boolean isEven(int num){
        return num % 2 == 0;
    }
    public Boolean containsA(String word){
        return word.contains("a");
    }

}