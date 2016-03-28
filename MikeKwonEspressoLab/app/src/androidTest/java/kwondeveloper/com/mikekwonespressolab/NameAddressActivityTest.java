package kwondeveloper.com.mikekwonespressolab;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Todo on 3/28/2016.
 */

@RunWith(AndroidJUnit4.class)
public class NameAddressActivityTest {

    @Rule
    public ActivityTestRule<NameAddressActivity> nameAddressActivityTestRule = new ActivityTestRule<NameAddressActivity>(NameAddressActivity.class);

    @Test
    public void testIfEverythingIsDisplayed() throws Exception {
        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.address)).check(matches(isDisplayed()));
    }
}
