package systemdesign.lld.designpattern.builder;

class BuilderDesignPattern {
    public static void main(String[] args) {
        Query query = QueryBuilder.getQueryBuilder().select("name").from("employee").where("name = 'shivam'").groupBy("name").orderBy("ASC").build();
        System.out.println(query);
    }
}

public class Query {
    private String select;
    private String from;
    private String where;
    private String groupBy;
    private String orderBy;

    public Query(String select, String from, String where, String groupBy, String orderBy) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.orderBy = orderBy;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhere() {
        return this.where;
    }

    @Override
    public String toString() {
        String query = "";

        if (null != this.select && !this.select.equals("")) {
            query = query.concat("SELECT " + this.select + " ");
        } else {
            throw new RuntimeException("SELECT is mandatory");
        }

        if (null != this.from && !this.from.equals("")) {
            query = query.concat("FROM " + this.from + " ");
        } else {
            throw new RuntimeException("FROM is mandatory");
        }

        if (null != this.where && !this.where.equals("")) {
            query = query.concat("WHERE " + this.where + " ");
        }

        if (null != this.groupBy && !this.groupBy.equals("")) {
            query = query.concat("GROUP BY " + this.groupBy + " ");
        }

        if (null != this.orderBy && !this.orderBy.equals("")) {
            query = query.concat("ORDER BY " + this.orderBy);
        }

        return query;
    }
}

class QueryBuilder {
    private String select;
    private String from;
    private String where;
    private String groupBy;
    private String orderBy;

    public static QueryBuilder getQueryBuilder() {
        return new QueryBuilder();
    }

    public QueryBuilder select(String select) {
        this.select = select;
        return this;
    }

    public QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    public QueryBuilder where(String where) {
        this.where = where;
        return this;
    }

    public QueryBuilder groupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }
    public QueryBuilder orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public Query build() {
        Query query = new Query(this.select, this.from, this.where, this.groupBy, this.orderBy);
        return query;
    }
}
