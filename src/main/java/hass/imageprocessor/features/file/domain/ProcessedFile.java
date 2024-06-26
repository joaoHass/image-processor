package hass.imageprocessor.features.file.domain;

import hass.imageprocessor.features.file.domain.enums.FileStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.ByteArrayInputStream;

@Getter
@Setter
public class ProcessedFile {
    @Setter(AccessLevel.PRIVATE)
    String originalName;
    String newName;
    ByteArrayInputStream convertedFile;
    FileStatus fileStatus;

    ProcessedFile(String originalName, String newName, ByteArrayInputStream convertedFile, FileStatus fileStatus) {
        this.originalName = originalName;
        this.newName = newName;
        this.convertedFile = convertedFile;
        this.fileStatus = fileStatus;
    }
}
