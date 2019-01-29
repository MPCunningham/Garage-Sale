/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.FeaturedItems;
import com.sg.garagesale.model.GarageSale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author LENOVO USER
 */
public class FeaturedItemsDaoImpl implements FeaturedItemsDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addItem(FeaturedItems items) {
        final String SQL_INSERT_ITEMS
                = "insert into FeaturedItems  (ItemCategory, ItemName, ItemDescription, GarageSaleID)"
                + "values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL_INSERT_ITEMS, items.getItemCategory(), items.getItemName(), items.getItemDescription(), items.getGarageSaleId());
        int itemID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        items.setItemId(itemID);

    }

    @Override
    public void deleteItem(int itemId) {
        final String SQL_DELETE_ALL_ITEMS = "delete from featureditems where ItemID = ?";
        jdbcTemplate.update(SQL_DELETE_ALL_ITEMS, itemId);
    }

    @Override
    public void updateItem(FeaturedItems item) {
        final String SQL_UPDATE_Item
                = "update featureditems set ItemCategory = ?, ItemName= ?, ItemDescription= ? where ItemID = ?";
        jdbcTemplate.update(SQL_UPDATE_Item, item.getItemCategory(), item.getItemName(), item.getItemDescription(), item.getItemId());
    }

    @Override
    public FeaturedItems getItem(int itemId) {
        final String SQL_SELECT_ITEM
                = "select * from featureditems where ItemID = ?";
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ItemsMapper(), itemId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<FeaturedItems> getItemsByGarageSale(int garageId) {
        final String SQL_SELECT_ITEM_BY_GARAGEID
                = "select * from featureditems where GarageSaleID =?";
        return jdbcTemplate.query(SQL_SELECT_ITEM_BY_GARAGEID, new ItemsMapper(), garageId);
    }

    @Override
    public List<FeaturedItems> getAllItems() {
        final String SQL_SELECT_ALLITEMS
                = "select * from featureditems";
        return jdbcTemplate.query(SQL_SELECT_ALLITEMS, new ItemsMapper());
    }

    @Override
    public void reset() {
        final String SQL_DELETE_FEATUREDITEMS
                = "delete from featureditems";
        jdbcTemplate.update(SQL_DELETE_FEATUREDITEMS);
    }

    private static final class ItemsMapper implements RowMapper<FeaturedItems> {

        @Override
        public FeaturedItems mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {

            FeaturedItems items = new FeaturedItems();
            items.setItemCategory(rs.getString("ItemCategory"));
            items.setItemDescription(rs.getString("ItemDescription"));
            items.setItemName(rs.getString("ItemName"));
            items.setItemId(rs.getInt("ItemID"));
            items.setGarageSaleId(rs.getInt("GarageSaleID"));

            return items;

        }
    }

}
