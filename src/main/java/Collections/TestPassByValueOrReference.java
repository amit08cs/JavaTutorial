package Collections;

import java.util.ArrayList;
import java.util.List;

public class TestPassByValueOrReference {
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    public List<String> method(List<String> list){
        list.add("a");
        list.add("b");
        return list;
    }
    public static void main(String[] args){
    	TestPassByValueOrReference mc1 = new TestPassByValueOrReference();
    	TestPassByValueOrReference mc2 = mc1;
        mc2.list1.add("c");
        mc2.list1 = mc2.list2;
        mc2.list1.add("d");
        List<String> list3 = mc2.method(mc2.list1);
        list3.add("e");
        System.out.println(mc1.list2);
    }
}