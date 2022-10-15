package com.miracl.nego.model;


import com.miracl.nego.entity.Protocol;
import com.miracl.nego.dao.ProtocolDAO;
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
public class ProtocolModel extends DefaultTableModel {

    private static final int PROTOCOL_NAME_INDEX = 0;
    private static final int BEHAVIOR_INDEX = 1;
    private static final int PARTNERS_NUMBER_INDEX = 2;
    private static final int ROUNDS_NUMBERS_INDEX = 3;
    private static final int ATTRIBUTES_NUMBER_INDEX = 4;

    
    private final ProtocolDAO dao;
    private static final String[] columnNames = new String[]{"PROTOCOL NAME", "BEHAVIOR", "PARTNERS NUMBER", "ROUNDS NUMBERS", "ATTRIBUTES NUMBER"};
   // private static final Class<?>[] columnTypes = {String.class, String.class, String.class, String.class, String.class};
    private List<Protocol> protocols = null;

    /**
     * 
     */
    public ProtocolModel() {
        super(columnNames, 0);
        dao = new ProtocolDAO();
    }

        /**
     *
     * @param p
     * @return
     */
    private static Object[] toArray(Protocol p) {
        return new Object[] {p.getProtocolName(), p.getBehavior(), p.getPartnersNumber(), p.getRoundsNumbers(), p.getAttributesNumber()};
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
        protocols = dao.findProtocolEntities();
        this.setDataVector(convert(protocols), columnNames);
    }
    
    /*
     * 
     */
    public void doListByBehavior(String behavior)
    {
    	protocols = dao.findByBehavior(behavior);
        this.setDataVector(convert(protocols), columnNames);
    }
    /*
     * 
     */
    public void doListByBehaviorAndPartners(String behavior, String partners)
    {
    	protocols = dao.findByBehaviorAndPartners(behavior, partners);
        this.setDataVector(convert(protocols), columnNames);
    }
    /*
     * 
     */
    public void doListByBehaviorAndPartnersAndRounds(String behavior, String partners, String rounds)
    {
    	protocols = dao.findByBehaviorAndPartnersAndRounds(behavior, partners, rounds);
        this.setDataVector(convert(protocols), columnNames);
    }
    /*
     * 
     */
    public void doLisByALL(String behavior, String partners, String rounds, String attributes)
    {
    	protocols = dao.findByALL(behavior, partners, rounds, attributes);
        this.setDataVector(convert(protocols), columnNames);
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
     * @param protocols
     * @return
     */
    private static Object[][] convert(List<Protocol> protocols) {
        if (protocols == null) {
            return new Object[0][columnNames.length];
        }

        Object[][] array = null;
        try {
            array = new Object[protocols.size()][columnNames.length];
            int i = 0;
            for (Protocol u : protocols) {
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
    public void add(Protocol p) {
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
    
    public Protocol getProtocolAt(int row) {
        if (row < 0) {
            throw new IndexOutOfBoundsException("row = " + row);
        }

        Protocol p = new Protocol();
        p.setProtocolName((String) getValueAt(row, PROTOCOL_NAME_INDEX));
        return p;
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

    /**
     * 
     * @param row
     * @return
     
   

    public List<Protocol> getListUser() {
        return protocols;
    }
    */
}
