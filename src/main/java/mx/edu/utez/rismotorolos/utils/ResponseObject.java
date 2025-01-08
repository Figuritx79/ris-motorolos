package mx.edu.utez.rismotorolos.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseObject {
    private TypeResponse typeResponse;
    private String message;
    private Object result;

    public ResponseObject(TypeResponse typeResponse, String message) {
        this.typeResponse = typeResponse;
        this.message = message;
    }

}
