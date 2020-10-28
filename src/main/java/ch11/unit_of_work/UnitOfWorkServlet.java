package ch11.unit_of_work;

import ch11.unit_of_work.mock.MockHttpServletRequest;
import ch11.unit_of_work.mock.MockHttpServletResponse;

public abstract class UnitOfWorkServlet {
    final protected void doGet(MockHttpServletRequest request, MockHttpServletResponse response) {
        try {
            UnitOfWork.newCurrent();
            handleGet(request, response);
            UnitOfWork.getCurrent().commit();
        } finally {
            UnitOfWork.setCurrent(null);
        }
    }

    abstract void handleGet(MockHttpServletRequest request, MockHttpServletResponse response);
}
