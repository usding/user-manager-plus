package com.fc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public StudentsExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdIsNull() {
            addCriterion("students.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("students.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("students.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("students.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("students.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("students.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("students.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("students.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("students.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("students.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("students.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("students.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("students.user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("students.user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("students.user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("students.user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("students.user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("students.user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("students.user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("students.user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("students.user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("students.user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("students.user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("students.user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("students.user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("students.user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("students.birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("students.birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterion("students.birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterion("students.birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterion("students.birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("students.birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterion("students.birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterion("students.birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterion("students.birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterion("students.birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterion("students.birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterion("students.birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("students.user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("students.user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("students.user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("students.user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("students.user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("students.user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("students.user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("students.user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("students.user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("students.user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("students.user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("students.user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("students.user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("students.user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("students.cert_type is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("students.cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(String value) {
            addCriterion("students.cert_type =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(String value) {
            addCriterion("students.cert_type <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(String value) {
            addCriterion("students.cert_type >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("students.cert_type >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(String value) {
            addCriterion("students.cert_type <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(String value) {
            addCriterion("students.cert_type <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLike(String value) {
            addCriterion("students.cert_type like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotLike(String value) {
            addCriterion("students.cert_type not like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<String> values) {
            addCriterion("students.cert_type in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<String> values) {
            addCriterion("students.cert_type not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(String value1, String value2) {
            addCriterion("students.cert_type between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(String value1, String value2) {
            addCriterion("students.cert_type not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNumberIsNull() {
            addCriterion("students.cert_number is null");
            return (Criteria) this;
        }

        public Criteria andCertNumberIsNotNull() {
            addCriterion("students.cert_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertNumberEqualTo(String value) {
            addCriterion("students.cert_number =", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotEqualTo(String value) {
            addCriterion("students.cert_number <>", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberGreaterThan(String value) {
            addCriterion("students.cert_number >", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberGreaterThanOrEqualTo(String value) {
            addCriterion("students.cert_number >=", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberLessThan(String value) {
            addCriterion("students.cert_number <", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberLessThanOrEqualTo(String value) {
            addCriterion("students.cert_number <=", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberLike(String value) {
            addCriterion("students.cert_number like", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotLike(String value) {
            addCriterion("students.cert_number not like", value, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberIn(List<String> values) {
            addCriterion("students.cert_number in", values, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotIn(List<String> values) {
            addCriterion("students.cert_number not in", values, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberBetween(String value1, String value2) {
            addCriterion("students.cert_number between", value1, value2, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCertNumberNotBetween(String value1, String value2) {
            addCriterion("students.cert_number not between", value1, value2, "certNumber");
            return (Criteria) this;
        }

        public Criteria andCelebritiesIsNull() {
            addCriterion("students.celebrities is null");
            return (Criteria) this;
        }

        public Criteria andCelebritiesIsNotNull() {
            addCriterion("students.celebrities is not null");
            return (Criteria) this;
        }

        public Criteria andCelebritiesEqualTo(String value) {
            addCriterion("students.celebrities =", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesNotEqualTo(String value) {
            addCriterion("students.celebrities <>", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesGreaterThan(String value) {
            addCriterion("students.celebrities >", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesGreaterThanOrEqualTo(String value) {
            addCriterion("students.celebrities >=", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesLessThan(String value) {
            addCriterion("students.celebrities <", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesLessThanOrEqualTo(String value) {
            addCriterion("students.celebrities <=", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesLike(String value) {
            addCriterion("students.celebrities like", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesNotLike(String value) {
            addCriterion("students.celebrities not like", value, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesIn(List<String> values) {
            addCriterion("students.celebrities in", values, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesNotIn(List<String> values) {
            addCriterion("students.celebrities not in", values, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesBetween(String value1, String value2) {
            addCriterion("students.celebrities between", value1, value2, "celebrities");
            return (Criteria) this;
        }

        public Criteria andCelebritiesNotBetween(String value1, String value2) {
            addCriterion("students.celebrities not between", value1, value2, "celebrities");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("students.marital_status is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("students.marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("students.marital_status =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("students.marital_status <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("students.marital_status >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("students.marital_status >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("students.marital_status <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("students.marital_status <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("students.marital_status like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("students.marital_status not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("students.marital_status in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("students.marital_status not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("students.marital_status between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("students.marital_status not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("students.phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("students.phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("students.phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("students.phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("students.phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("students.phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("students.phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("students.phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("students.phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("students.phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("students.phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("students.phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("students.phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("students.phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andCertAddressIsNull() {
            addCriterion("students.cert_address is null");
            return (Criteria) this;
        }

        public Criteria andCertAddressIsNotNull() {
            addCriterion("students.cert_address is not null");
            return (Criteria) this;
        }

        public Criteria andCertAddressEqualTo(String value) {
            addCriterion("students.cert_address =", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotEqualTo(String value) {
            addCriterion("students.cert_address <>", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressGreaterThan(String value) {
            addCriterion("students.cert_address >", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressGreaterThanOrEqualTo(String value) {
            addCriterion("students.cert_address >=", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressLessThan(String value) {
            addCriterion("students.cert_address <", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressLessThanOrEqualTo(String value) {
            addCriterion("students.cert_address <=", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressLike(String value) {
            addCriterion("students.cert_address like", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotLike(String value) {
            addCriterion("students.cert_address not like", value, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressIn(List<String> values) {
            addCriterion("students.cert_address in", values, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotIn(List<String> values) {
            addCriterion("students.cert_address not in", values, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressBetween(String value1, String value2) {
            addCriterion("students.cert_address between", value1, value2, "certAddress");
            return (Criteria) this;
        }

        public Criteria andCertAddressNotBetween(String value1, String value2) {
            addCriterion("students.cert_address not between", value1, value2, "certAddress");
            return (Criteria) this;
        }

        public Criteria andDomicileIsNull() {
            addCriterion("students.domicile is null");
            return (Criteria) this;
        }

        public Criteria andDomicileIsNotNull() {
            addCriterion("students.domicile is not null");
            return (Criteria) this;
        }

        public Criteria andDomicileEqualTo(String value) {
            addCriterion("students.domicile =", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileNotEqualTo(String value) {
            addCriterion("students.domicile <>", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileGreaterThan(String value) {
            addCriterion("students.domicile >", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileGreaterThanOrEqualTo(String value) {
            addCriterion("students.domicile >=", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileLessThan(String value) {
            addCriterion("students.domicile <", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileLessThanOrEqualTo(String value) {
            addCriterion("students.domicile <=", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileLike(String value) {
            addCriterion("students.domicile like", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileNotLike(String value) {
            addCriterion("students.domicile not like", value, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileIn(List<String> values) {
            addCriterion("students.domicile in", values, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileNotIn(List<String> values) {
            addCriterion("students.domicile not in", values, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileBetween(String value1, String value2) {
            addCriterion("students.domicile between", value1, value2, "domicile");
            return (Criteria) this;
        }

        public Criteria andDomicileNotBetween(String value1, String value2) {
            addCriterion("students.domicile not between", value1, value2, "domicile");
            return (Criteria) this;
        }

        public Criteria andLocalEstateIsNull() {
            addCriterion("students.local_estate is null");
            return (Criteria) this;
        }

        public Criteria andLocalEstateIsNotNull() {
            addCriterion("students.local_estate is not null");
            return (Criteria) this;
        }

        public Criteria andLocalEstateEqualTo(String value) {
            addCriterion("students.local_estate =", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateNotEqualTo(String value) {
            addCriterion("students.local_estate <>", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateGreaterThan(String value) {
            addCriterion("students.local_estate >", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateGreaterThanOrEqualTo(String value) {
            addCriterion("students.local_estate >=", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateLessThan(String value) {
            addCriterion("students.local_estate <", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateLessThanOrEqualTo(String value) {
            addCriterion("students.local_estate <=", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateLike(String value) {
            addCriterion("students.local_estate like", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateNotLike(String value) {
            addCriterion("students.local_estate not like", value, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateIn(List<String> values) {
            addCriterion("students.local_estate in", values, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateNotIn(List<String> values) {
            addCriterion("students.local_estate not in", values, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateBetween(String value1, String value2) {
            addCriterion("students.local_estate between", value1, value2, "localEstate");
            return (Criteria) this;
        }

        public Criteria andLocalEstateNotBetween(String value1, String value2) {
            addCriterion("students.local_estate not between", value1, value2, "localEstate");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonIsNull() {
            addCriterion("students.accompany_person is null");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonIsNotNull() {
            addCriterion("students.accompany_person is not null");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonEqualTo(String value) {
            addCriterion("students.accompany_person =", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonNotEqualTo(String value) {
            addCriterion("students.accompany_person <>", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonGreaterThan(String value) {
            addCriterion("students.accompany_person >", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("students.accompany_person >=", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonLessThan(String value) {
            addCriterion("students.accompany_person <", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonLessThanOrEqualTo(String value) {
            addCriterion("students.accompany_person <=", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonLike(String value) {
            addCriterion("students.accompany_person like", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonNotLike(String value) {
            addCriterion("students.accompany_person not like", value, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonIn(List<String> values) {
            addCriterion("students.accompany_person in", values, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonNotIn(List<String> values) {
            addCriterion("students.accompany_person not in", values, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonBetween(String value1, String value2) {
            addCriterion("students.accompany_person between", value1, value2, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andAccompanyPersonNotBetween(String value1, String value2) {
            addCriterion("students.accompany_person not between", value1, value2, "accompanyPerson");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNull() {
            addCriterion("students.postal_code is null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNotNull() {
            addCriterion("students.postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeEqualTo(String value) {
            addCriterion("students.postal_code =", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotEqualTo(String value) {
            addCriterion("students.postal_code <>", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThan(String value) {
            addCriterion("students.postal_code >", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("students.postal_code >=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThan(String value) {
            addCriterion("students.postal_code <", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("students.postal_code <=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLike(String value) {
            addCriterion("students.postal_code like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotLike(String value) {
            addCriterion("students.postal_code not like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIn(List<String> values) {
            addCriterion("students.postal_code in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotIn(List<String> values) {
            addCriterion("students.postal_code not in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeBetween(String value1, String value2) {
            addCriterion("students.postal_code between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotBetween(String value1, String value2) {
            addCriterion("students.postal_code not between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("students.email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("students.email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("students.email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("students.email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("students.email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("students.email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("students.email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("students.email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("students.email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("students.email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("students.email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("students.email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("students.email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("students.email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("students.wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("students.wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("students.wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("students.wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("students.wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("students.wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("students.wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("students.wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("students.wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("students.wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("students.wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("students.wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("students.wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("students.wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("students.batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("students.batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("students.batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("students.batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("students.batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("students.batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("students.batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("students.batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("students.batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("students.batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("students.batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("students.batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("students.batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("students.batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("students.deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("students.deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(Long value) {
            addCriterion("students.deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Long value) {
            addCriterion("students.deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Long value) {
            addCriterion("students.deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("students.deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Long value) {
            addCriterion("students.deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Long value) {
            addCriterion("students.deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Long> values) {
            addCriterion("students.deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Long> values) {
            addCriterion("students.deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Long value1, Long value2) {
            addCriterion("students.deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Long value1, Long value2) {
            addCriterion("students.deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentIsNull() {
            addCriterion("students.final_payment is null");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentIsNotNull() {
            addCriterion("students.final_payment is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentEqualTo(Long value) {
            addCriterion("students.final_payment =", value, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentNotEqualTo(Long value) {
            addCriterion("students.final_payment <>", value, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentGreaterThan(Long value) {
            addCriterion("students.final_payment >", value, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentGreaterThanOrEqualTo(Long value) {
            addCriterion("students.final_payment >=", value, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentLessThan(Long value) {
            addCriterion("students.final_payment <", value, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentLessThanOrEqualTo(Long value) {
            addCriterion("students.final_payment <=", value, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentIn(List<Long> values) {
            addCriterion("students.final_payment in", values, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentNotIn(List<Long> values) {
            addCriterion("students.final_payment not in", values, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentBetween(Long value1, Long value2) {
            addCriterion("students.final_payment between", value1, value2, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andFinalPaymentNotBetween(Long value1, Long value2) {
            addCriterion("students.final_payment not between", value1, value2, "finalPayment");
            return (Criteria) this;
        }

        public Criteria andTotalCostIsNull() {
            addCriterion("students.total_cost is null");
            return (Criteria) this;
        }

        public Criteria andTotalCostIsNotNull() {
            addCriterion("students.total_cost is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCostEqualTo(Long value) {
            addCriterion("students.total_cost =", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotEqualTo(Long value) {
            addCriterion("students.total_cost <>", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostGreaterThan(Long value) {
            addCriterion("students.total_cost >", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostGreaterThanOrEqualTo(Long value) {
            addCriterion("students.total_cost >=", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostLessThan(Long value) {
            addCriterion("students.total_cost <", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostLessThanOrEqualTo(Long value) {
            addCriterion("students.total_cost <=", value, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostIn(List<Long> values) {
            addCriterion("students.total_cost in", values, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotIn(List<Long> values) {
            addCriterion("students.total_cost not in", values, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostBetween(Long value1, Long value2) {
            addCriterion("students.total_cost between", value1, value2, "totalCost");
            return (Criteria) this;
        }

        public Criteria andTotalCostNotBetween(Long value1, Long value2) {
            addCriterion("students.total_cost not between", value1, value2, "totalCost");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("students.note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("students.note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("students.note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("students.note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("students.note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("students.note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("students.note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("students.note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("students.note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("students.note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("students.note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("students.note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("students.note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("students.note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCertFscanIsNull() {
            addCriterion("students.cert_fscan is null");
            return (Criteria) this;
        }

        public Criteria andCertFscanIsNotNull() {
            addCriterion("students.cert_fscan is not null");
            return (Criteria) this;
        }

        public Criteria andCertFscanEqualTo(String value) {
            addCriterion("students.cert_fscan =", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanNotEqualTo(String value) {
            addCriterion("students.cert_fscan <>", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanGreaterThan(String value) {
            addCriterion("students.cert_fscan >", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanGreaterThanOrEqualTo(String value) {
            addCriterion("students.cert_fscan >=", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanLessThan(String value) {
            addCriterion("students.cert_fscan <", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanLessThanOrEqualTo(String value) {
            addCriterion("students.cert_fscan <=", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanLike(String value) {
            addCriterion("students.cert_fscan like", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanNotLike(String value) {
            addCriterion("students.cert_fscan not like", value, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanIn(List<String> values) {
            addCriterion("students.cert_fscan in", values, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanNotIn(List<String> values) {
            addCriterion("students.cert_fscan not in", values, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanBetween(String value1, String value2) {
            addCriterion("students.cert_fscan between", value1, value2, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertFscanNotBetween(String value1, String value2) {
            addCriterion("students.cert_fscan not between", value1, value2, "certFscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanIsNull() {
            addCriterion("students.cert_bscan is null");
            return (Criteria) this;
        }

        public Criteria andCertBscanIsNotNull() {
            addCriterion("students.cert_bscan is not null");
            return (Criteria) this;
        }

        public Criteria andCertBscanEqualTo(String value) {
            addCriterion("students.cert_bscan =", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanNotEqualTo(String value) {
            addCriterion("students.cert_bscan <>", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanGreaterThan(String value) {
            addCriterion("students.cert_bscan >", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanGreaterThanOrEqualTo(String value) {
            addCriterion("students.cert_bscan >=", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanLessThan(String value) {
            addCriterion("students.cert_bscan <", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanLessThanOrEqualTo(String value) {
            addCriterion("students.cert_bscan <=", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanLike(String value) {
            addCriterion("students.cert_bscan like", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanNotLike(String value) {
            addCriterion("students.cert_bscan not like", value, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanIn(List<String> values) {
            addCriterion("students.cert_bscan in", values, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanNotIn(List<String> values) {
            addCriterion("students.cert_bscan not in", values, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanBetween(String value1, String value2) {
            addCriterion("students.cert_bscan between", value1, value2, "certBscan");
            return (Criteria) this;
        }

        public Criteria andCertBscanNotBetween(String value1, String value2) {
            addCriterion("students.cert_bscan not between", value1, value2, "certBscan");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueIsNull() {
            addCriterion("students.photo_blue is null");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueIsNotNull() {
            addCriterion("students.photo_blue is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueEqualTo(String value) {
            addCriterion("students.photo_blue =", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueNotEqualTo(String value) {
            addCriterion("students.photo_blue <>", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueGreaterThan(String value) {
            addCriterion("students.photo_blue >", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueGreaterThanOrEqualTo(String value) {
            addCriterion("students.photo_blue >=", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueLessThan(String value) {
            addCriterion("students.photo_blue <", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueLessThanOrEqualTo(String value) {
            addCriterion("students.photo_blue <=", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueLike(String value) {
            addCriterion("students.photo_blue like", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueNotLike(String value) {
            addCriterion("students.photo_blue not like", value, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueIn(List<String> values) {
            addCriterion("students.photo_blue in", values, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueNotIn(List<String> values) {
            addCriterion("students.photo_blue not in", values, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueBetween(String value1, String value2) {
            addCriterion("students.photo_blue between", value1, value2, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andPhotoBlueNotBetween(String value1, String value2) {
            addCriterion("students.photo_blue not between", value1, value2, "photoBlue");
            return (Criteria) this;
        }

        public Criteria andCertGscanIsNull() {
            addCriterion("students.cert_gscan is null");
            return (Criteria) this;
        }

        public Criteria andCertGscanIsNotNull() {
            addCriterion("students.cert_gscan is not null");
            return (Criteria) this;
        }

        public Criteria andCertGscanEqualTo(String value) {
            addCriterion("students.cert_gscan =", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanNotEqualTo(String value) {
            addCriterion("students.cert_gscan <>", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanGreaterThan(String value) {
            addCriterion("students.cert_gscan >", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanGreaterThanOrEqualTo(String value) {
            addCriterion("students.cert_gscan >=", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanLessThan(String value) {
            addCriterion("students.cert_gscan <", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanLessThanOrEqualTo(String value) {
            addCriterion("students.cert_gscan <=", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanLike(String value) {
            addCriterion("students.cert_gscan like", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanNotLike(String value) {
            addCriterion("students.cert_gscan not like", value, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanIn(List<String> values) {
            addCriterion("students.cert_gscan in", values, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanNotIn(List<String> values) {
            addCriterion("students.cert_gscan not in", values, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanBetween(String value1, String value2) {
            addCriterion("students.cert_gscan between", value1, value2, "certGscan");
            return (Criteria) this;
        }

        public Criteria andCertGscanNotBetween(String value1, String value2) {
            addCriterion("students.cert_gscan not between", value1, value2, "certGscan");
            return (Criteria) this;
        }

        public Criteria andBelongIsNull() {
            addCriterion("students.belong is null");
            return (Criteria) this;
        }

        public Criteria andBelongIsNotNull() {
            addCriterion("students.belong is not null");
            return (Criteria) this;
        }

        public Criteria andBelongEqualTo(Integer value) {
            addCriterion("students.belong =", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotEqualTo(String value) {
            addCriterion("students.belong <>", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThan(String value) {
            addCriterion("students.belong >", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThanOrEqualTo(String value) {
            addCriterion("students.belong >=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThan(String value) {
            addCriterion("students.belong <", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThanOrEqualTo(String value) {
            addCriterion("students.belong <=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLike(String value) {
            addCriterion("students.belong like", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotLike(String value) {
            addCriterion("students.belong not like", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongIn(List<String> values) {
            addCriterion("students.belong in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotIn(List<String> values) {
            addCriterion("students.belong not in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongBetween(String value1, String value2) {
            addCriterion("students.belong between", value1, value2, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotBetween(String value1, String value2) {
            addCriterion("students.belong not between", value1, value2, "belong");
            return (Criteria) this;
        }
    }

    /**
     */
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