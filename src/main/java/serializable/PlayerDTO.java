package serializable;

import java.io.Serializable;

public class PlayerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    String name;
    int height;
    String position;

    public PlayerDTO(String name, int height, String position) {
        this.name = name;
        this.height = height;
        this.position = position;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", position='" + position + '\'' +
                '}';
    }
}
