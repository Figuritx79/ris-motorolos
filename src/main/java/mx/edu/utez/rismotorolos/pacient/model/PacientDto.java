package mx.edu.utez.rismotorolos.pacient.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PacientDto(

        @NotNull(groups = {
                PacientDto.ChangeStatus.class, PacientDto.Insert.class,
                PacientDto.Delete.class }, message = "THe id can not by null") @Positive(groups = { ChangeStatus.class,
                        Update.class, Delete.class }, message = "Id has been positive") long id,

        @NotNull(groups = { PacientDto.Insert.class }) @NotBlank(groups = { PacientDto.Insert.class }) String name,
        @NotBlank(groups = { PacientDto.Insert.class }) String lastName,

        @NotBlank(groups = { PacientDto.Insert.class, PacientDto.Update.class }) @NotNull(groups = {
                PacientDto.Insert.class,
                PacientDto.Update.class }, message = "Curp can not be null") String curp)

    {

    public interface ChangeStatus {
    }

    public interface Update {
    }

    public interface Insert {
    }

    public interface Delete {
    }
}
