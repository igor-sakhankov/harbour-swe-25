### Summary

Add a brief reasoning for the PR here, a few sentences describing the PR so that anyone from your team or another team
can get a grasp on the scope of the changes.

### Database Queries

- [ ] Added/modified queries have been verified with [EXPLAIN](https://dev.mysql.com/doc/refman/8.4/en/using-explain.html) against Production DB: *Attach a screenshot or paste results of the explain here*

### Security

- [ ] The changes do not
  expose [PII](https://glovoapp.atlassian.net/wiki/spaces/PRODUCT/pages/1400242434/How+to...+Handle+users+personal+data+GDPR)
- [ ] The changes include audit log

### How to rollback?
**In case it has no instructions the On-Call engineer will rollback without asking for confirmation.*

**Toggles:**
- TOOGLE_A_ENABLED=false
- TOOGLE_B_ENABLED=true