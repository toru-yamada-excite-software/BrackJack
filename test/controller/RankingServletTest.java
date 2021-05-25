package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import dbmodel.UserDB;
import model.User;

public class RankingServletTest {

	@InjectMocks
	private RankingServlet rs = new RankingServlet();

	@Mock
	private UserDB udb;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void doGetTest() throws Exception {

		String id = "1";
		String password = "p";
		String name = "nn";

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HttpSession session = request.getSession();
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		session.setAttribute("user", user);

		ArrayList<User> ranking = new ArrayList<User>();
		ranking.add(user);

		doReturn(ranking).when(udb).getRanking();
		doReturn(1).when(udb).getMyRanking("1");

		rs.doGet(request, response);

		ArrayList<User> getList = (ArrayList<User>) request.getAttribute("ranking");
		int actualRank = (int) request.getAttribute("myRank");
		String actualId = getList.get(0).getId();
		String actualPassword = getList.get(0).getPassword();
		String actualName = getList.get(0).getName();

		int expectedRank = 1;

		assertThat(actualId, is(id));
		assertThat(actualPassword, is(password));
		assertThat(actualName, is(name));
		assertThat(actualRank, is(expectedRank));

	}

}
