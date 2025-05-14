import java.io.Serializable;

public class Document implements DocumentInterface {
    public Document() {}

    public String getPage(){
        return "page";
    }
}
class Printer{
    DocumentInterface d;
    Printer(DocumentInterface d){
        this.d = d;
    }
    void print(){
        System.out.println(d.getPage());
    }
}
class Factory{
    void produce(){
        Document d = new Document();
        Printer p = new Printer(d);
        p.print();
    }
}
 interface DocumentInterface{
    String getPage();
 }