package section10.interfaces.challenge;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);
}