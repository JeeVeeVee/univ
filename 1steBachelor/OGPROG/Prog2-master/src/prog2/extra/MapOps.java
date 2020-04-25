package prog2.extra;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapOps {

        private Map<String, List<Persoon>> map;

        public void registerValue(String key, Persoon value) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
}
