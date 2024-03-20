import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ListOfStations {

    private MetroStation station;
    private List<MetroStation> list = new ArrayList<>();

}
