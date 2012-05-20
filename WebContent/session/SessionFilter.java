package java.session;


import java.bean.UtilBean;
import java.entity.Conta;
import java.logger.SystemLogger;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author italobruno
 */
public class SessionFilter implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Create a session
        SystemLogger.save(Level.INFO, "Sessão criada: " + new UtilBean().formatDateAndHour(new Date()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Destroy a session        
        Conta c = (Conta) se.getSession().getAttribute("conta");
        if (c != null) {
            SystemLogger.save(Level.INFO, c.getNome() + " encerrou sua sessão: " + new UtilBean().formatDateAndHour(new Date()));
        } else {
            SystemLogger.save(Level.INFO, "Usuário não autenticado encerrou uma sessão: " + new UtilBean().formatDateAndHour(new Date()));
        }
    }
}
