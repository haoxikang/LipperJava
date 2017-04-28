package com.fallllllll.lipper.core.rxjava.exceptionalhandling;

import com.fallllllll.lipper.core.exception.NetworkException;

import org.json.JSONException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.HttpException;

import static org.junit.Assert.*;

/**
 * Created by fallllllll on 2017/3/14.
 */
@RunWith(Parameterized.class)
public class ExceptionTest {

    @Parameterized.Parameter
    public Throwable e;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();
    @Mock
    static HttpException httpException;

    @Parameterized.Parameters
    public static Collection<Throwable> initData() {
        List<Throwable> throwables = new ArrayList<>();

        throwables.add(new JSONException("JSONException"));
        throwables.add(new ConnectException("ConnectException"));
        throwables.add(new NullPointerException("NullPointerException"));
        throwables.add(null);

        return throwables;
    }


    @Test
    public void testHandleException() {
        ApiException apiException;
        if (e != null) {
            apiException = NetworkException.handleException(e);
        } else {
            apiException = NetworkException.handleException(httpException);
        }


        if (e instanceof JSONException) {
            assertEquals(apiException.code, ERROR.PARSE_ERROR);
        }
        if (e instanceof ConnectException) {
            assertEquals(apiException.code, ERROR.NETWORD_ERROR);
        }
        if (e instanceof NullPointerException) {
            assertEquals(apiException.code, ERROR.UNKNOWN);
        }
        if (e == null) {
            assertEquals(apiException.code, ERROR.HTTP_ERROR);
        }
    }

}