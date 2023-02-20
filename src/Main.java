import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        int day = 20;
        int month = 2;
        int year = 2012;
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        String result = "";
        LocalDate birhday = LocalDate.of(year, month, day);
        LocalDate toDay = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy - E")
                .localizedBy(new Locale("us"));
        int i = 0;
        while (birhday.isBefore(toDay) || birhday.isEqual(toDay)) {
            result += i++ + " - " + birhday.format(formatter) + "\n";
            birhday = birhday.plusYears(1);
        }
        return result;
    }
}
