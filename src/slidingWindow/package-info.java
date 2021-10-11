package slidingWindow;

/*
 * So to apply two-pointer technique, we need to put some constraint on the sub-string within the window
 *
 * The problems that are a great fit for sliding window technique all have a clear constraint stated in the problem description
 * which can be easily fixed by shrinking the window, when the window has been extended too far.
 *
 * In Problem like 395. Longest Substring with At Least K Repeating Characters though, when you are extending the window
 * and just encountered a character that has appeared less than k in the window, it's not clear that if shrinking the
 * window at this moment will fix the constraint
 */