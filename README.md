# s3bench

[![CircleCI](https://circleci.com/gh/tukeJonny/s3bench.svg?style=svg)](https://circleci.com/gh/tukeJonny/s3bench)

Benchmarker for Amazon S3 compatible object storage written in clojure.

## Usage

### How to run

```
$ lein run
9 20, 2020 3:37:33 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [!] Start benchmarking !!
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   1        400       662.000         216.000         440.750      221.260             217.000         223.000         662.000         662.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   2       1000       228.000         210.000         219.150        5.952             213.000         220.000         223.000         228.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   3        800       310.000         203.000         226.500       23.917             213.000         222.000         229.000         275.500    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   4        900       464.000         199.000         237.333       59.643             211.500         215.000         230.000         379.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   5        900       227.000         199.000         213.556        7.440             208.500         212.000         218.500         226.500    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   6        900       443.000         200.000         222.833       53.835             203.000         209.000         215.000         333.500    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   7        750       448.000         201.000         239.600       59.498             210.500         218.000         234.000         361.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   8        800      1202.000         199.000         279.813      238.473             203.000         216.000         231.000         720.500    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
   9        850       257.000         214.000         230.412       12.277             222.000         228.000         231.500         256.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
  10        950       247.000         197.000         221.053       14.066             209.500         218.000         235.000         244.500    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
  11        800       254.000         200.000         219.688       15.755             205.000         215.000         224.000         251.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
  12        800       537.000         201.000         253.500       76.591             220.000         227.000         249.000         419.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
  13        650      1310.000         203.000         335.538      291.819             212.500         228.000         263.000         911.000    0
time    size[B] max-lat[msec]   min-lat[msec]   avg-lat[msec]   stddev-lat      lat(p25)[msec]  lat(p50)[msec]  lat(p75)[msec]  lat(p99)[msec]  err
  14        950       243.000         200.000         213.789        8.983             207.500         212.000         215.000         233.500    0
9 20, 2020 3:37:48 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [-] Shutdown workers ...
9 20, 2020 3:37:48 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [-] Shutdown reporter ...
========== Final Result ==========
Written: 11450 [Bytes]
Throughput:
    Total:           715.625 [Bytes/sec]
    Max:             1000.000 [Bytes/sec]
    Min:             400.000 [Bytes/sec]
    Avg              817.857 [Bytes/sec]
    Stddev:          145.905
    Percentile(25%): 775.000 [Bytes/sec]
    Percentile(50%): 800.000 [Bytes/sec]
    Percentile(75%): 900.000 [Bytes/sec]
    Percentile(99%): 975.000 [Bytes/sec]
Latency:
    Max:             1310.000 [msec]
    Min:             197.000 [msec]
    Avg              243.856 [msec]
    Stddev:          118.544
    Percentile(25%): 211.000 [msec]
    Percentile(50%): 218.000 [msec]
    Percentile(75%): 229.000 [msec]
    Percentile(99%): 662.000 [msec]
Err: 0

9 20, 2020 3:37:48 午後 clojure.tools.logging$eval218$fn__223 invoke
情報: [*] Cleaning objects ...
9 20, 2020 3:39:14 午後 clojure.tools.logging$eval218$fn__223 invoke
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
