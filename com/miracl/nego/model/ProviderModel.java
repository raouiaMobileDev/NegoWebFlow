package com.miracl.nego.model;

import com.miracl.nego.entity.Provider;
import com.miracl.nego.dao.ProviderDAO;
import com.miracl.nego.dao.exceptions.NonexistentEntityException;
//import com.miracl.nego.util.RegexUtils;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rawia BOUABDELLAH - MIRACL
 */
//private List<User> users;
public class ProviderModel extends DefaultTableModel {

    private static final int ID_PROVIDER_INDEX = 0;
    private static final int SERVICE_NAME_INDEX = 1;
    private static final int TRAINING_NAME_INDEX = 2;
    private static final int CONTRIBUTOR_INDEX = 3;
    private static final int HOURS_INDEX = 4;
    private static final int PRICE_INDEX = 5;
    private static final int CERTIFICATE_INDEX = 6;
    private static final int ORGANIZATION_NAME_INDEX = 7;
    private static final int ENDPOINT_INDEX = 8;
    
    private final ProviderDAO dao;
    private static final String[] columnNames = new String[]{"ID", "Service name", "Training name", "Contributor", "Hours", "price", "Certificate", "Organisation name", "Endpoint"};
   // private static final Class<?>[] columnTypes = {Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class};
    private List<Provider> providers = null;

    /**
     * 
     */
    public ProviderModel() {
        super(columnNames, 0);
        dao = new ProviderDAO();
    }

        /**
     *
     * @param p
     * @return
     */
    private static Object[] toArray(Provider p) {
        return new Object[] {p.getIdProvider(), p.getServiceName(), p.getTrainingName(), p.getContributor(), p.getHours(), p.getPrice(), p.getCertificate(), p.getOrganizationName(), p.getEndpoint()};
    }

    /**
     * 
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * 
     * @param columnIndex
     * @return
     
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }
    
    */

    /**
     * 
     */
    public void doList() {  
        providers = dao.findProviderEntities();
        this.setDataVector(convert(providers), columnNames);
    }
    
    /*
     * 
     */
    public void doListService(String serviceName) {  
        providers = dao.findByService(serviceName);
        this.setDataVector(convert(providers), columnNames);
    }
    /*
     * 
     */
    public void doListContributor(String contributor) {  
        providers = dao.findByContributor(contributor);
        this.setDataVector(convert(providers), columnNames);
    }
    
    public void doListServiceAndContributor(String serviceName, String contributor) {  
        providers = dao.findByServiceAndContributor(serviceName, contributor);
        this.setDataVector(convert(providers), columnNames);
    }
    /**
     * 
     */
    private void doClear() {
        for (int i = 0; i < getRowCount(); ++i) {
            removeRow(0);
        }
    }

    /**
     *
     * @param providers
     * @return
     */
    private static Object[][] convert(List<Provider> providers) {
        if (providers == null) {
            return new Object[0][columnNames.length];
        }

        Object[][] array = null;
        try {
            array = new Object[providers.size()][columnNames.length];
            int i = 0;
            for (Provider u : providers) {
                array[i] = toArray(u);
                i++;
            }
        } catch (Exception e) {
        }
        return array;
    }

    /**
     *
     * @param p
     */
    public void add(Provider p) {
        try {
         //   if (isValid(p)) {
                dao.create(p);
                Object[] o = toArray(p);
                this.addRow(o);
          //  } else {
                JOptionPane.showMessageDialog(null, "Invalide");
          //  }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param provider
     * @return
    
    private boolean isValid(Provider provider) {
        System.out.println(provider);

        if (provider == null) {
            return false;
        }
        if (StringUtils.isBlank(provider.getLogin())) {
            return false;
        }
        if (StringUtils.isBlank(provider.getFirstname())) {
            return false;
        }
        if (StringUtils.isBlank(provider.getLastname())) {
            return false;
        }
        if (StringUtils.isBlank(provider.getMail())) {
            return false;
        }
        if (StringUtils.isBlank(provider.getCin())) {
            return false;
        }
        if (!provider.getCin().matches("[0-9]{8}")) {
            return false;
        }
        if (!RegexUtils.checkMail(provider.getMail())) {
            return false;
        }
        return true;
    }
 */
    /**
     *
     * @param u
     * @param row
    
    public void delete(int row) {
        try {
            String login = (String) getValueAt(row, LOGIN_INDEX);
            dao.destroy(login);
            this.removeRow(row);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProviderModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param p
     * @param row
     
    public boolean update(Provider p, int row) {
        try {
            if (isValid(p)) {
                dao.edit(p);
                setUserAt(p, row);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalide");
                return false;
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProviderModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProviderModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     */

    /**
     * 
     * @param user
     * @param row
    
    private void setUserAt(User user, int row) {
        setValueAt(user.getLogin(), row, LOGIN_INDEX);
        setValueAt(user.getPassword(), row, PASSWORD_INDEX);
        setValueAt(user.getFirstname(), row, FIRSTNAME_INDEX);
        setValueAt(user.getLastname(), row, LASTNAME_INDEX);
        setValueAt(user.getCin(), row, CIN_INDEX);
        setValueAt(user.getMail(), row, MAIL_INDEX);
    }
     */

    
   
    public Provider getProviderAt(int row) {
        if (row < 0) {
            throw new IndexOutOfBoundsException("row = " + row);
        }

        Provider p = new Provider();
        p.setIdProvider((Integer) getValueAt(row, ID_PROVIDER_INDEX));
        p.setServiceName((String) getValueAt(row, SERVICE_NAME_INDEX));
        p.setTrainingName((String) getValueAt(row, TRAINING_NAME_INDEX));
        p.setContributor((String) getValueAt(row, CONTRIBUTOR_INDEX));
        p.setHours((Integer) getValueAt(row, HOURS_INDEX));
        p.setPrice((Integer) getValueAt(row, PRICE_INDEX));
        p.setCertificate((Boolean) getValueAt(row, CERTIFICATE_INDEX));
        p.setOrganizationName((String) getValueAt(row, ORGANIZATION_NAME_INDEX));
        p.setEndpoint((String) getValueAt(row, ENDPOINT_INDEX));
        return p;
    }

    public List<Provider> getListUser() {
        return providers;
    }
}
