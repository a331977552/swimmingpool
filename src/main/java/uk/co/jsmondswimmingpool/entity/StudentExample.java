package uk.co.jsmondswimmingpool.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(String value) {
            addCriterion("startDate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(String value) {
            addCriterion("startDate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(String value) {
            addCriterion("startDate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("startDate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(String value) {
            addCriterion("startDate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(String value) {
            addCriterion("startDate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLike(String value) {
            addCriterion("startDate like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotLike(String value) {
            addCriterion("startDate not like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<String> values) {
            addCriterion("startDate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<String> values) {
            addCriterion("startDate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(String value1, String value2) {
            addCriterion("startDate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(String value1, String value2) {
            addCriterion("startDate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andMaxIsNull() {
            addCriterion("Max is null");
            return (Criteria) this;
        }

        public Criteria andMaxIsNotNull() {
            addCriterion("Max is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEqualTo(Integer value) {
            addCriterion("Max =", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotEqualTo(Integer value) {
            addCriterion("Max <>", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThan(Integer value) {
            addCriterion("Max >", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("Max >=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThan(Integer value) {
            addCriterion("Max <", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThanOrEqualTo(Integer value) {
            addCriterion("Max <=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxIn(List<Integer> values) {
            addCriterion("Max in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotIn(List<Integer> values) {
            addCriterion("Max not in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxBetween(Integer value1, Integer value2) {
            addCriterion("Max between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("Max not between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andMinIsNull() {
            addCriterion("min is null");
            return (Criteria) this;
        }

        public Criteria andMinIsNotNull() {
            addCriterion("min is not null");
            return (Criteria) this;
        }

        public Criteria andMinEqualTo(Integer value) {
            addCriterion("min =", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotEqualTo(Integer value) {
            addCriterion("min <>", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThan(Integer value) {
            addCriterion("min >", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("min >=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThan(Integer value) {
            addCriterion("min <", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThanOrEqualTo(Integer value) {
            addCriterion("min <=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinIn(List<Integer> values) {
            addCriterion("min in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotIn(List<Integer> values) {
            addCriterion("min not in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinBetween(Integer value1, Integer value2) {
            addCriterion("min between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotBetween(Integer value1, Integer value2) {
            addCriterion("min not between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNull() {
            addCriterion("current is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNotNull() {
            addCriterion("current is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEqualTo(Integer value) {
            addCriterion("current =", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotEqualTo(Integer value) {
            addCriterion("current <>", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThan(Integer value) {
            addCriterion("current >", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThanOrEqualTo(Integer value) {
            addCriterion("current >=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThan(Integer value) {
            addCriterion("current <", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThanOrEqualTo(Integer value) {
            addCriterion("current <=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentIn(List<Integer> values) {
            addCriterion("current in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotIn(List<Integer> values) {
            addCriterion("current not in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentBetween(Integer value1, Integer value2) {
            addCriterion("current between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotBetween(Integer value1, Integer value2) {
            addCriterion("current not between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andWeeksIsNull() {
            addCriterion("weeks is null");
            return (Criteria) this;
        }

        public Criteria andWeeksIsNotNull() {
            addCriterion("weeks is not null");
            return (Criteria) this;
        }

        public Criteria andWeeksEqualTo(String value) {
            addCriterion("weeks =", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotEqualTo(String value) {
            addCriterion("weeks <>", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksGreaterThan(String value) {
            addCriterion("weeks >", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksGreaterThanOrEqualTo(String value) {
            addCriterion("weeks >=", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLessThan(String value) {
            addCriterion("weeks <", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLessThanOrEqualTo(String value) {
            addCriterion("weeks <=", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksLike(String value) {
            addCriterion("weeks like", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotLike(String value) {
            addCriterion("weeks not like", value, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksIn(List<String> values) {
            addCriterion("weeks in", values, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotIn(List<String> values) {
            addCriterion("weeks not in", values, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksBetween(String value1, String value2) {
            addCriterion("weeks between", value1, value2, "weeks");
            return (Criteria) this;
        }

        public Criteria andWeeksNotBetween(String value1, String value2) {
            addCriterion("weeks not between", value1, value2, "weeks");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberIsNull() {
            addCriterion("parentPhoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberIsNotNull() {
            addCriterion("parentPhoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberEqualTo(String value) {
            addCriterion("parentPhoneNumber =", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberNotEqualTo(String value) {
            addCriterion("parentPhoneNumber <>", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberGreaterThan(String value) {
            addCriterion("parentPhoneNumber >", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("parentPhoneNumber >=", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberLessThan(String value) {
            addCriterion("parentPhoneNumber <", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberLessThanOrEqualTo(String value) {
            addCriterion("parentPhoneNumber <=", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberLike(String value) {
            addCriterion("parentPhoneNumber like", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberNotLike(String value) {
            addCriterion("parentPhoneNumber not like", value, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberIn(List<String> values) {
            addCriterion("parentPhoneNumber in", values, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberNotIn(List<String> values) {
            addCriterion("parentPhoneNumber not in", values, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberBetween(String value1, String value2) {
            addCriterion("parentPhoneNumber between", value1, value2, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentphonenumberNotBetween(String value1, String value2) {
            addCriterion("parentPhoneNumber not between", value1, value2, "parentphonenumber");
            return (Criteria) this;
        }

        public Criteria andParentnameIsNull() {
            addCriterion("parentName is null");
            return (Criteria) this;
        }

        public Criteria andParentnameIsNotNull() {
            addCriterion("parentName is not null");
            return (Criteria) this;
        }

        public Criteria andParentnameEqualTo(String value) {
            addCriterion("parentName =", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotEqualTo(String value) {
            addCriterion("parentName <>", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameGreaterThan(String value) {
            addCriterion("parentName >", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameGreaterThanOrEqualTo(String value) {
            addCriterion("parentName >=", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameLessThan(String value) {
            addCriterion("parentName <", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameLessThanOrEqualTo(String value) {
            addCriterion("parentName <=", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameLike(String value) {
            addCriterion("parentName like", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotLike(String value) {
            addCriterion("parentName not like", value, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameIn(List<String> values) {
            addCriterion("parentName in", values, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotIn(List<String> values) {
            addCriterion("parentName not in", values, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameBetween(String value1, String value2) {
            addCriterion("parentName between", value1, value2, "parentname");
            return (Criteria) this;
        }

        public Criteria andParentnameNotBetween(String value1, String value2) {
            addCriterion("parentName not between", value1, value2, "parentname");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionIsNull() {
            addCriterion("MedicalCondition is null");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionIsNotNull() {
            addCriterion("MedicalCondition is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionEqualTo(String value) {
            addCriterion("MedicalCondition =", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionNotEqualTo(String value) {
            addCriterion("MedicalCondition <>", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionGreaterThan(String value) {
            addCriterion("MedicalCondition >", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionGreaterThanOrEqualTo(String value) {
            addCriterion("MedicalCondition >=", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionLessThan(String value) {
            addCriterion("MedicalCondition <", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionLessThanOrEqualTo(String value) {
            addCriterion("MedicalCondition <=", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionLike(String value) {
            addCriterion("MedicalCondition like", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionNotLike(String value) {
            addCriterion("MedicalCondition not like", value, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionIn(List<String> values) {
            addCriterion("MedicalCondition in", values, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionNotIn(List<String> values) {
            addCriterion("MedicalCondition not in", values, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionBetween(String value1, String value2) {
            addCriterion("MedicalCondition between", value1, value2, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andMedicalconditionNotBetween(String value1, String value2) {
            addCriterion("MedicalCondition not between", value1, value2, "medicalcondition");
            return (Criteria) this;
        }

        public Criteria andPaidIsNull() {
            addCriterion("Paid is null");
            return (Criteria) this;
        }

        public Criteria andPaidIsNotNull() {
            addCriterion("Paid is not null");
            return (Criteria) this;
        }

        public Criteria andPaidEqualTo(Integer value) {
            addCriterion("Paid =", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotEqualTo(Integer value) {
            addCriterion("Paid <>", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThan(Integer value) {
            addCriterion("Paid >", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Paid >=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThan(Integer value) {
            addCriterion("Paid <", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThanOrEqualTo(Integer value) {
            addCriterion("Paid <=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidIn(List<Integer> values) {
            addCriterion("Paid in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotIn(List<Integer> values) {
            addCriterion("Paid not in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidBetween(Integer value1, Integer value2) {
            addCriterion("Paid between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotBetween(Integer value1, Integer value2) {
            addCriterion("Paid not between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("Note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("Note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("Note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("Note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("Note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("Note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("Note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("Note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("Note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("Note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("Note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("Note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("Note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("Note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}