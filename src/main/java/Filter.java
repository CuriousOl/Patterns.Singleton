import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = source.stream()
                .filter(i -> i >= threshold)
                .collect(Collectors.toList());
        return result;
    }
}
