import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MetroStation {
    private final String name;
    private final String number;

    @Override
    public String toString() {
        return name + ": " + number;
    }
}
