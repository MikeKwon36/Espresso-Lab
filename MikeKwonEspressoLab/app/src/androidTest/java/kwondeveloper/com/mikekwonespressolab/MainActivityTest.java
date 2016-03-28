package kwondeveloper.com.mikekwonespressolab;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testIfEverythingIsDisplayed() throws Exception {
        onView(withId(R.id.currentBalanceTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.transactionsListView)).check(matches(isDisplayed()));
        onView(withId(R.id.transactionValueEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.addValueButton)).check(matches(isDisplayed()));
        onView(withId(R.id.reduceValueButton)).check(matches(isDisplayed()));
        onView(withId(R.id.checkNameAddressButton)).check(matches(isDisplayed()));
    }

    @Test
    public void testAddValueButtonUpdatesCurrentBalance() throws Exception {
        String value1 = "1";
        String expectedValue = "1";
        onView(withId(R.id.transactionValueEditText)).perform(typeText(value1), closeSoftKeyboard());
        onView(withId(R.id.addValueButton)).perform(click());
        onView(withId(R.id.currentBalanceTextView)).check(matches(withText(expectedValue)));
    }

    @Test
    public void testReduceValueButtonUpdatesList() throws Exception {
        String value1 = "1";
        String expectedValue = "-1";
        onView(withId(R.id.transactionValueEditText)).perform(typeText(value1),closeSoftKeyboard());
        onView(withId(R.id.reduceValueButton)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).check(matches(withText(expectedValue)));
    }
}