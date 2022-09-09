package serializable;

import java.io.Serializable;

public class PlayerDTO implements Serializable {
    String name;
    int height;
    String position;

    public PlayerDTO(String name, int height, String position) {
        this.name = name;
        this.height = height;
        this.position = position;
    }
}
