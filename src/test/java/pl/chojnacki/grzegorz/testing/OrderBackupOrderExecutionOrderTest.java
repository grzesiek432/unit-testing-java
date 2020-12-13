package pl.chojnacki.grzegorz.testing;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupOrderExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingAFileFirstShouldThrowException() throws IOException {
        //given
        OrderBackup orderBackup = new OrderBackup();


        //then
        assertThrows(IOException.class,() -> orderBackup.backupOrder(new Order()));

    }
}
