import com.spring.knights.BraveKnight;
import com.spring.knights.Quest;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BraveKnightTest {
    @Test
    public void knightShounldEmabrkOnQuest(){
        Quest mockQuest =mock(Quest.class);
        BraveKnight knight =new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest,times(1)).embark();
    }
}
