package hass.imageprocessor.features.file.domain.filestoragestrategy;

import lombok.Getter;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.nio.file.Path;

@Getter
public class LocalFileStorageStrategy implements FileStorageStrategy {

    private final Path _storagePath;

    public LocalFileStorageStrategy() throws IOException {
        _storagePath = Path.of(
                FileSystemView.getFileSystemView().getDefaultDirectory().getPath(),
                "processed_images"
        );
        Files.createDirectories(_storagePath);
    }

    @Override
    public Future<String> asyncSave(InputStream fileStream, String fileName) throws IOException, IllegalArgumentException {
        if (fileStream == null) {
            throw new IllegalArgumentException("fileStream cannot be null");
        }
        if (fileName == null) {
            throw new IllegalArgumentException("fileName cannot be null");
        }

        String filePath = Path.of(_storagePath.toString(), fileName).toString();

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(fileStream.readAllBytes());
        }

        return CompletableFuture.completedFuture(filePath);
    }
}
