# s3bench

[![CircleCI](https://circleci.com/gh/tukeJonny/s3bench.svg?style=svg)](https://circleci.com/gh/tukeJonny/s3bench)

Benchmarker for Amazon S3 compatible object storage written in clojure.

## Usage

### How to run

```
$ lein run
9 20, 2020 2:56:46 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [!] Start benchmarking !!
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       200            897.000         292.000         642.250      219.165             292.000         690.000         690.000         793.500    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       700           1351.000         204.000         328.857      294.413             217.000         227.000         237.500         941.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       250           1166.000         262.000         609.000      314.182             312.000         482.500         627.500         909.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       550           1320.000         200.000         490.636      408.585             216.500         238.500         585.500        1304.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       800            433.000         202.000         233.438       52.908             210.000         215.000         230.000         341.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
      1000            275.000         202.000         221.650       20.338             207.000         213.000         225.000         268.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       900            234.000         203.000         218.278        7.929             213.000         217.000         222.500         232.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       850            248.000         220.000         237.941        8.980             231.000         241.000         245.000         248.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       750            350.000         206.000         250.200       36.708             215.000         245.000         269.000         313.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       600            538.000         212.000         287.583      108.656             226.000         243.000         263.000         527.500    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       650            887.000         204.000         359.385      217.278             214.000         222.000         401.500         754.500    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       700            549.000         201.000         266.357       82.568             221.500         245.000         271.500         420.000    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       300            912.000         290.000         519.667      198.223             345.000         419.000         548.500         749.500    0
written[B]      max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
       500           1020.000         258.000         427.200      220.152             268.500         338.000         457.500         788.500    0
9 20, 2020 2:57:01 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [-] Shutdown workers ...
9 20, 2020 2:57:01 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [-] Shutdown reporter ...
========== Final Result ==========
Written: 8750 [Bytes]
Throughput:
    Total:           546.875 [Bytes/sec]
    Max:             1000.000 [Bytes/sec]
    Min:             200.000 [Bytes/sec]
    Avg              625.000 [Bytes/sec]
    Stddev:          235.091
    Percentile(25%): 400.000 [Bytes/sec]
    Percentile(50%): 650.000 [Bytes/sec]
    Percentile(75%): 775.000 [Bytes/sec]
    Percentile(99%): 950.000 [Bytes/sec]
Latency:
    Max:             1351.000 [msec]
    Min:             200.000 [msec]
    Avg              312.869 [msec]
    Stddev:          208.976
    Percentile(25%): 217.000 [msec]
    Percentile(50%): 232.000 [msec]
    Percentile(75%): 271.500 [msec]
    Percentile(99%): 1304.000 [msec]
Err: 0

9 20, 2020 2:57:01 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [*] Cleaning objects ...
9 20, 2020 2:58:07 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [-] Shutdown s3bench.
```

### Check CSV file

```
$ cat /tmp/2020-09-20_15-9-786.csv
time,written-bytes,max-latency,min-latency,avg-latency,stddev-latency,p25-latency,p50-latency,p75-latency,p99-latency,err-count
1,350,993.0,208.0,521.4285714285714,285.8250499583154,212.5,445.0,671.0,832.0,0
2,750,295.0,202.0,234.46666666666667,31.876567499584326,206.0,222.0,253.0,291.5,0
3,950,511.0,202.0,242.89473684210526,65.68336706610947,215.0,220.0,240.5,395.5,0
4,900,233.0,199.0,213.11111111111111,8.943581738933661,204.0,211.0,219.0,228.5,0
5,900,236.0,198.0,211.66666666666666,8.491826135237998,206.5,210.0,215.0,229.0,0
6,950,252.0,199.0,222.05263157894737,12.34791132651283,216.0,222.5,224.5,249.0,0
7,950,247.0,200.0,217.6315789473684,11.53124143732463,209.0,215.5,223.5,241.5,0
8,900,243.0,199.0,214.22222222222223,9.548446968286143,208.5,213.0,217.0,234.0,0
9,900,258.0,200.0,225.66666666666666,15.748015748023622,215.0,218.0,237.0,253.5,0
10,700,343.0,204.0,241.28571428571428,46.253074911572206,212.5,216.0,230.0,338.5,0
11,700,991.0,210.0,357.14285714285717,216.67449488736298,220.0,247.0,409.5,788.0,0
12,800,277.0,201.0,228.625,22.527413855123275,211.0,221.0,235.0,271.0,0
13,800,261.0,210.0,231.625,14.9744574192189,218.0,226.0,243.0,257.5,0
14,700,756.0,222.0,302.2857142857143,128.16865483273455,254.0,264.0,277.0,535.0,0
```

## License

Copyright © 2020 tukeJonny

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
