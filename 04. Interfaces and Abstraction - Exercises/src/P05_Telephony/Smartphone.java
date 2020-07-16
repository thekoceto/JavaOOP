package P05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder report = new StringBuilder();
        for (String url : this.urls) {
            if (isValidUrl(url))
                report.append("Browsing: ").append(url).append("!");
            else
                report.append("Invalid URL!");
            report.append(System.lineSeparator());
        }
        return report.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder report = new StringBuilder();
        for (String number : this.numbers) {
            if (isValidNumber(number))
                report.append("Calling... ").append(number);
            else
                report.append("Invalid number!");
            report.append(System.lineSeparator());
        }
        return report.toString().trim();
    }

    private boolean isValidNumber(String number) {
        for (char ch : number.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }

    private boolean isValidUrl(String url) {
        for (char ch : url.toCharArray()) {
            if (Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
