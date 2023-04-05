package comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Applicant> {
    public int compare(Applicant a1, Applicant a2) {
        int nameComp = a1.getName().compareTo(a2.getName());
        return nameComp;
    }
}