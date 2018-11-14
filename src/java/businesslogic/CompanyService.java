package businesslogic;

import dataaccess.CompanyDB;
import dataaccess.UserDB;
import domainmodel.Company;
import domainmodel.Role;
import domainmodel.User;
import java.util.List;

public class CompanyService {

    private CompanyDB companyDB;

    public CompanyService() {
        companyDB = new CompanyDB();
    }

    public Company getCompany(int companyID) throws Exception {
        return companyDB.getCompany(companyID);
    }

    public List<Company> getAll() throws Exception {
        return companyDB.getAll();
    }

    public int update(int companyID, String companyName) throws Exception {

        Company company = companyDB.getCompany(companyID);
        company.setCompanyName(companyName);
        return companyDB.update(company);
    }

    public int delete(int companyID) throws Exception {
        Company deleteComapny = companyDB.getCompany(companyID);
        return companyDB.delete(deleteComapny);
    }

    public int insert(String companyName) throws Exception {

        Company comapny = new Company(0, companyName);
        return companyDB.insert(comapny);
    }
}
