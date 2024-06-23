package hass.imageprocessor.filestoragestrategy;

import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Future;

public interface FileStorageStrategy {
    @Async
    Future<String> asyncSave(InputStream fileStream, String fileName) throws IOException;
}
