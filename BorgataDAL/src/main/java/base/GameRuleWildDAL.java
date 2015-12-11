package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.GameRuleWildDomainModel;
import util.HibernateUtil;

public class GameRuleWildDAL {

	public static ArrayList<GameRuleWildDomainModel> getWildRules() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ArrayList<GameRuleWildDomainModel> Rules = new ArrayList<GameRuleWildDomainModel>();

		try {
			tx = session.beginTransaction();

			List rules = session.createQuery("FROM GameRuleWildDomainModel").list();
			for (Iterator iterator = rules.iterator(); iterator.hasNext();) {
				GameRuleWildDomainModel rle = (GameRuleWildDomainModel) iterator.next();
				Rules.add(rle);

			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Rules;

	}

	
}
