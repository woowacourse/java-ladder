package dto;

import java.util.List;

public class UsersDTO {
    private final List<String> usersDTO;

    public UsersDTO(final List<String> usersDTO) {
        this.usersDTO = usersDTO;
    }

    public List<String> getUsersDTO() {
        return usersDTO;
    }
}
